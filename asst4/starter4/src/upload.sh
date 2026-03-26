#!/bin/bash

if [[ "$1" == "-r" ]]; then
	rm summary.txt output.txt
	ssh rhoades26@cs358.campus.up.edu 'cat asst4/summary.txt' > summary.txt
	ssh rhoades26@cs358.campus.up.edu 'cat asst4/output.txt' > output.txt
else

	./comp
	rm -f outputlocal.txt

	if [[ -n "$1" && "$1" != "-s" ]]; then
		: > outputlocal.txt
	fi
	
	for file in ../*.java; do
		[ -f "$file" ] || continue

		if [[ -n "$1" && "$1" != "-s" ]]; then
			./run "$file" "$1" >> outputlocal.txt
		else
			./run "$file"
		fi
	done   

	if [[ "$1" == "-s" ]]; then
		ssh rhoades26@cs358.campus.up.edu 'rm asst4/*'
		rm handin.zip
		zip handin.zip -j visitor/Sem4Visitor.java visitor/Sem5Visitor.java
		scp handin.zip rhoades26@cs358.campus.up.edu:asst4/handin.zip
	fi

fi