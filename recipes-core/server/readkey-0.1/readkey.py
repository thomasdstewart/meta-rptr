#!/usr/bin/python
import evdev
import urllib2
import sys
from pprint import pprint as pp

devices = [evdev.InputDevice(fn) for fn in evdev.list_devices()]

for dev in devices:
    if('flirc' in dev.name):
        flirc=dev.fn

dev = evdev.InputDevice(flirc)

for event in dev.read_loop():
    if(event.type == evdev.ecodes.EV_KEY and event.value == 1):
        key = evdev.ecodes.KEY[event.code]
        pp(key)
        if(key == 'KEY_PLAYPAUSE'):
            urllib2.urlopen("http://localhost:5000/play").read()

        #if(key == 'KEY_'):
        #    urllib2.urlopen("http://localhost:5000/pause").read()

        if(key == 'KEY_STOPCD'):
            urllib2.urlopen("http://localhost:5000/stop").read()

        if(key == 'KEY_FASTFORWARD'):
            urllib2.urlopen("http://localhost:5000/fastforward").read()

        if(key == 'KEY_REWIND'):
            urllib2.urlopen("http://localhost:5000/rewind").read()

        #if(key == 'KEY_'):
        #    urllib2.urlopen("http://localhost:5000/record").read()
