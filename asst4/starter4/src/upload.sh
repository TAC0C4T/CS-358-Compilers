#!/bin/bash

./comp
for file in ../*.java; do
  [ -f "$file" ] && ./run "$file"
done   

if [[ "$1" == "-s" ]]; then
	ssh rhoades26@cs358.campus.up.edu 'rm asst4/*'
	rm handin.zip
	zip handin.zip -j visitor/Sem4.java visitor/Sem5.java
	scp handin.zip rhoades26@cs358.campus.up.edu:asst4/handin.zip
fi
