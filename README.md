# Interview Suite

Hi! Interview suite is a collection of Java exercises you can use to test your Data Structure knowledge and learn how to master the main well-known algorithms any software engineer should know. 


## Structure

Inside the `exercise` package you can find all the exercises for implementing **algorithms** and **data structures**. Each exercise comes with a set of already-made *unit tests* you can use to check that your implementation works as expected. No hassle!

The `algorithm` sub-package uses pre-made data structures (e.g. Tree, Graph) so that you only have to focus on the algorithm itself.

If, on the other end, you feel like trying and implement some of the data structures yourself, the `ds` sub-package will provide interfaces for data structure (and unit test) that you can dive into and have fun with!

**Note to reader**
Implementing a complete Graph data structure with proper abstraction and hierarchy is most likely well-beyond the scope of any interview. Most of the times the Data Structure will be tailored to the problem at hand. Therefore, what you see inside this package is a simple version of the data structures used for the algorithms. 

# Getting Started

- Clone this repo locally
```Bash
git clone https://github.com/spad-on/InterviewSuite.git
```

- Import the project into your editor of choice (e.g. IntelliJ, Eclipse, etc.).

## Testing

### Run single test
You can run **all tests** by using the command
```bash
mvn test
```
from inside the root folder of this repo (where the `pom.xml` is located).

Alternatively, on a n Unix/Mac machine you can use the `run_all_tests` script inside the `bin` folder.
First `cd` into the `bin` folder
```bash
cd ./bin
```
and then run
```bash
./run_all_tests.sh
```

### Run a single test
Sometimes you might want to run a single test. You can do this easily on Unix/Mac machines by going to the `bin` sub-folder
```bash
cd ./bin
```
 and using the available scripts:
```bash
./run_test.sh <testCase>
```
On *Windows* machines you might get away with it by running the script on a *GitBash* shell (this has NOT been tested though). Alternatively, simply use the equivalent `mvn` command to achieve the same behaviour.

To get a list of **available tests cases** you can run the following:
```bash
./list_tests.sh
```
