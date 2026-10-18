This is a gateway (or more properly bridge) that reads from
the native TCP/IP network and forwards DIS binary traffic to
web pages in binary format. A javascript implementation of
DIS on the web page decodes the binary DIS and updates a google
maps display. 

The websocket gateway is a web server that listens on, by default,
port 8282. Run the project in netbeans (or via ant), open a
web browser, and go to http://localhost:8282. If you are connected
to the internet you should see a Google Maps display.

The web page begins sending binary DIS updates to the gateway
over a websocket. Likewise, the gateway will begin forwarding the
local TCP/IP internet DIS traffic to the web page. The web page
will load a clickable icon showing the position of the entity.

The local web page uses browser geolocation to create an entity
at the approximate location of the user. 

The index.html web page in the content directory holds the 
default web page. Supporting javascript files are in 
content/javascript, and the DIS implementation is in 
content/javascript/dis.js.

The web server is a Jetty websockets host as well. 

This uses my personal Google Maps API key. That's fine for demo
puproses, but please get your own API key for any real world
use.

License is BSD. 

* Copyright (c) 2006-2020, Naval Postgraduate School, MOVES Institute
* All rights reserved.
* Redistribution and use in source and binary forms, with or without
* modification, are permitted provided that the following conditions are met:
*
*     * Redistributions of source code must retain the above copyright
*       notice, this list of conditions and the following disclaimer.
*     * Redistributions in binary form must reproduce the above copyright
*       notice, this list of conditions and the following disclaimer in the
*       documentation and/or other materials provided with the distribution.
*     * Neither the name of the Naval Postgraduate School, MOVES Institute, nor the
*       names of its contributors may be used to endorse or promote products
*       derived from this software without specific prior written permission.
*
* THIS SOFTWARE IS PROVIDED BY NPS AND CONTRIBUTORS ``AS IS'' AND ANY
* EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
* WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
* DISCLAIMED. IN NO EVENT SHALL THE REGENTS AND CONTRIBUTORS BE LIABLE FOR ANY
* DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
* (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
* LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
* ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
* (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
* SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
DMcG
