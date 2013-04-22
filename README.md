StackSites
==========

Stack Sites is an example Android application that demonstrates how to parse some custom XML data and display it nicely in a ListView.

It will teach you how to turn xml data like this:

    <?xml version="1.0" encoding="UTF-8"?>
    <stack-sites>
        <site>
            <name>Stack Overflow</name>
            <link>http://stackoverflow.com/</link>
            <about>Stack Overflow is a question and answer site for professional and enthusiast programmers.</about>
            <image>https://dl.dropboxusercontent.com/u/5724095/XmlParseExample/stackoverflow.png</image>
        </site>
        <site>
            <name>English Language &amp; Usage</name>
            <link>http://english.stackexchange.com/</link>
            <about>English Language &amp; Usage Stack Exchange is a question and answer site for linguists, etymologists, and serious English language enthusiasts.</about>
            <image>https://dl.dropboxusercontent.com/u/5724095/XmlParseExample/english.png</image>
        </site>
        <site>
            <name>Mathematics</name>
            <link>http://math.stackexchange.com</link>
            <about>Mathematics Stack Exchange is a question and answer site for people studying math at any level and professionals in related fields.</about>
            <image>https://dl.dropboxusercontent.com/u/5724095/XmlParseExample/math.png</image>
        </site>
        ...
    </stack-sites>
    
Into a pretty ListView like this:

![Stack Sites](https://dl.dropboxusercontent.com/u/5724095/images/stacksites.png)

    Copyright 2013 Tim Cocks

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.