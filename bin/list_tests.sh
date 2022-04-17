#!/usr/bin/env bash

get_pom_dir() {
  script_file=$(realpath $0)
  script_dir=$(dirname "$script_file")
  echo `dirname "$script_dir"`
}

pom_dir=`get_pom_dir`

if [ ! -f "$pom_dir/pom.xml" ]; then
  echo "pom.xml not found in $pom_dir"
  exit 1
fi

search_dir="${pom_dir}/src/test"
if [ ! -d "$search_dir" ]; then
  echo "test folder not found in $search_dir"
  exit 1
fi

find "$search_dir" -type f -name "Test*.java" | sed -E 's/.*\/([^\/]+)\.java/\1/' | sort