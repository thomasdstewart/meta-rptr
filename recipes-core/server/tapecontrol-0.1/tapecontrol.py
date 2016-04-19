#!/usr/bin/python
from flask import Flask
import RPi.GPIO as GPIO
import time
import sys
from pprint import pprint as pp
#http://python-evdev.readthedocs.org/en/latest/tutorial.html

enable = 4
fastforward = 17
play = 18
rewind = 22
stop = 23
record = 24
pause = 25
on = GPIO.LOW
off = GPIO.HIGH

def init():
    GPIO.setmode(GPIO.BCM)
    GPIO.setup(enable, GPIO.OUT)
    GPIO.output(enable, off)
    time.sleep(0.5)
    GPIO.setup([fastforward, play, rewind, stop, record, pause], GPIO.OUT)
    GPIO.output([fastforward, play, rewind, stop, record, pause], off)
    GPIO.output(enable, on)

def clean():
    GPIO.output(enable, off)
    GPIO.cleanup()

def togglecmd(cmd):
    if(cmd == 'fastforward'):
        cmd = fastforward
    elif(cmd == 'play'):
        cmd = play
    elif(cmd == 'rewind'):
        cmd = rewind
    elif(cmd == 'stop'):
        cmd = stop
    elif(cmd == 'record'):
        cmd = record
    elif(cmd == 'pause'):
        cmd = pause
    else:
        print("unknown command")
        return

    GPIO.output(cmd, on)
    time.sleep(0.2)
    GPIO.output(cmd, off)

html='''
<p>
<a href=/play>play</a>
<a href=/pause>pause</a>
<a href=/stop>stop</a>
<a href=/fastforward>fastforward</a>
<a href=/rewind>rewind</a>
<a href=/record>record</a>
</p>
'''

app = Flask(__name__)
@app.route('/')
def help():
    return html

@app.route('/<cmd>')
def docmd(cmd):
    print(cmd)
    togglecmd(cmd)

    return '%s<br><p>cmd: %s</p>' % (html, cmd) 

if __name__ == '__main__':
    init() 
    app.debug = True
    app.run(host='0.0.0.0')
    clean()

