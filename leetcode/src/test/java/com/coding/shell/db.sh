#!/usr/bin/env bash
test -d ../shell
echo $?
if [ $? -eq 0 ]
  then
      echo "fff"
fi

echo "ddd"
