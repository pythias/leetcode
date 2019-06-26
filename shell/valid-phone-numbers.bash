#!/bin/bash
#https://leetcode.com/problems/valid-phone-numbers/
#Given a text file file.txt that contains list of phone numbers (one per line), write a one liner bash script to print all valid phone numbers.
#You may assume that a valid phone number must appear in one of the following two formats: (xxx) xxx-xxxx or xxx-xxx-xxxx. (x means a digit)
#You may also assume each line in the text file must not contain leading or trailing white spaces.

cat file.txt | grep -E "^([0-9]{3}-|\([0-9]{3}\) )[0-9]{3}-[0-9]{4}$" 
