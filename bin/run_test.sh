#!/usr/bin/env bash

get_pom_dir() {
  script_file=$(realpath $0)
  script_dir=$(dirname "$script_file")
  echo $(dirname "$script_dir")
}

if (( $# < 1 )); then
  echo    "============================================"
  echo    "Usage: $0 <test_class> [test_method1]"
  echo    "Run list_tests.sh to find a list of all test classes"
  echo -n "Run list_test_class.sh to find a list of all test methods"
  echo    " for a specific test class"
  echo    "============================================"
  exit 1
fi

# Fetch test class
test_class="$1"

# Fetch methods within class
test_method=
if (( $# >= 2 )); then
  test_method="$2"
fi

# Construct test_pattern flag
if [ -n "$test_method" ]; then
  test_pattern="${test_class}#${test_method}"
else
  test_pattern="${test_class}"
fi

# Run command
pom_dir=`get_pom_dir`

if [ ! -f "$pom_dir/pom.xml" ]; then
  echo "pom.xml not found in $pom_dir"
  exit 1
fi

echo "Running mvn -f $pom_dir -Dtest=${test_pattern} test"
mvn -f "$pom_dir" -Dtest="${test_pattern}" test
