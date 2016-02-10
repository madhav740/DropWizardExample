#!/bin/bash
sudo kill -9 `ps -eaf | grep java|grep bss.jar |tr -s ' \t' ' '| cut -d' ' -f2`| true

