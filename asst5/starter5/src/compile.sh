#!/bin/bash

make clean
make
./run ../tests/$1 -a mjLib.asm