#!/usr/bin/env bash

get_pom_dir() {
  script_file=$(realpath $0)
  script_dir=$(dirname "$script_file")
  echo `dirname "$script_dir"`
}

if (( $# < 1 )); then
  echo "============================================"
  echo "Usage: $0 <test_class>"
  echo "Run list_tests.sh to get a full list of test classes"
  echo "============================================"
  exit 1
fi

test_class="$1"

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

# Look for the .java file
filename=$(find "$search_dir" -type f -name "${test_class}.java")

# Check a file has been found and it exists
if [ -z "$filename" ] || [ ! -f "$filename" ]; then
  echo "Test class '${test_class} not found"
  exit 1
fi

# Parse the file and extract test* methods
cat "$filename" | grep -o -E '(test[a-zA-Z0-9]+)\s*\(\s*\)' | sed -E 's/\s*\(\s*\)//'
