#!/bin/bash

./comp
for file in ../Test*.java; do
  [ -f "$file" ] && ./run "$file"
done   

if [[ "$1" == "-s" ]]; then
	ssh rhoades26@cs358.campus.up.edu 'rm asst3/*'
	rm handin.zip
	zip handin.zip -j visitor/Sem*.java
	scp handin.zip rhoades26@cs358.campus.up.edu:asst3/handin.zip
fi
