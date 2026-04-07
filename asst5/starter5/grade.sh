#!/bin/bash
cd src
make
cd ..
python grade.py tests5a
