package com.makemyandroidapp.example.stacksites;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.content.Context;

public class SitesXmlPullParser {

	static final String KEY_SITE = "site";
	static final String KEY_NAME = "name";
	static final String KEY_LINK = "link";
	static final String KEY_ABOUT = "about";
	static final String KEY_IMAGE_URL = "image";

	public static List<StackSite> getStackSitesFromFile(Context ctx) {

		// List of StackSites that we will return
		List<StackSite> stackSites;
		stackSites = new ArrayList<StackSite>();

		// temp holder for current StackSite while parsing
		StackSite curStackSite = null;
		// temp holder for current text value while parsing
		String curText = "";

		try {
			// Get our factory and PullParser
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = factory.newPullParser();

			// Open up InputStream and Reader of our file.
			FileInputStream fis = ctx.openFileInput("StackSites.xml");
			BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

			// point the parser to our file.
			xpp.setInput(reader);

			// get initial eventType
			int eventType = xpp.getEventType();

			// Loop through pull events until we reach END_DOCUMENT
			while (eventType != XmlPullParser.END_DOCUMENT) {
				// Get the current tag
				String tagname = xpp.getName();

				// React to different event types appropriately
				switch (eventType) {
				case XmlPullParser.START_TAG:
					if (tagname.equalsIgnoreCase(KEY_SITE)) {
						// If we are starting a new <site> block we need
						//a new StackSite object to represent it
						curStackSite = new StackSite();
					}
					break;

				case XmlPullParser.TEXT:
					//grab the current text so we can use it in END_TAG event
					curText = xpp.getText();
					break;

				case XmlPullParser.END_TAG:
					if (tagname.equalsIgnoreCase(KEY_SITE)) {
						// if </site> then we are done with current Site
						// add it to the list.
						stackSites.add(curStackSite);
					} else if (tagname.equalsIgnoreCase(KEY_NAME)) {
						// if </name> use setName() on curSite
						curStackSite.setName(curText);
					} else if (tagname.equalsIgnoreCase(KEY_LINK)) {
						// if </link> use setLink() on curSite
						curStackSite.setLink(curText);
					} else if (tagname.equalsIgnoreCase(KEY_ABOUT)) {
						// if </about> use setAbout() on curSite
						curStackSite.setAbout(curText);
					} else if (tagname.equalsIgnoreCase(KEY_IMAGE_URL)) {
						// if </image> use setImgUrl() on curSite
						curStackSite.setImgUrl(curText);
					}
					break;

				default:
					break;
				}
				//move on to next iteration
				eventType = xpp.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// return the populated list.
		return stackSites;
	}
}
