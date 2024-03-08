Report: Sudoku solver
Introduction
In this report, we review and explain the code of a Java program for solving Sudoku problems using a backtracking algorithm. 
Sudoku is a popular game that involves filling a 9x9 grid with digits so that each column, 
each row, and each of the nine 3x3 subgrids contains all digits from 1 to 9 without repetition.

Performance and features
- This program solves Sudoku problems using backtracking algorithm.
- Provides a command line interface for user interaction.

Use
1: Clone the repository to your local machine.
2: Compile the Sudoku.java file using a Java compiler.
3: Run the compiled program and face the instructions to enter the sudoku puzzle.
4: The program solves the puzzle and displays the answer.
How to solve sudoku:
The Sudoku solving algorithm used in this code is a backtracking algorithm. 
This algorithm recursively starts from the first Sudoku cell and tries to choose a suitable value for each cell. 
If a chosen value does not lead to a correct solution, it goes back and tries other values. 
This process continues until all the cells are filled and a correct solution to the Sudoku is found.

The important points in solving Sudoku with backtracking algorithm are:

1. Choosing the right value for each cell: The algorithm recursively selects a value for each cell and can choose from a set of possible values (between 1 and 9 in the case of Sudoku).

2. Validity check: After selecting a value for a cell, the algorithm checks whether this value remaining from solving the problem is correct or not. If it is correct, it goes to the next cell; If not, it resets the previous value and selects another value.

3. Go back to previous cells: If we reach a point where we cannot find a suitable value for the current cell, the algorithm will go back and try to choose other values for the previous cells.

4. The end of the algorithm: The algorithm ends when all the cells are filled and a correct solution for Sudoku is found.

This process continues until all values are filled and a correct solution is found.

Example
Entrance:
5 3 0 0 7 0 0 0 0
6 0 0 1 9 5 0 0 0
0 9 8 0 0 0 0 6 0
8 0 0 0 6 0 0 0 3
4 0 0 8 0 3 0 0 1
7 0 0 0 2 0 0 0 6
0 6 0 0 0 0 2 8 0
0 0 0 4 1 9 0 0 5
0 0 0 0 8 0 0 7 9
```

Output:
```
5 3 4 6 7 8 9 1 2
6 7 2 1 9 5 3 4 8
1 9 8 3 4 2 5 6 7
8 5 9 7 6 1 4 2 3
4 2 6 8 5 3 7 9 1
7 1 3 9 2 4 8 5 6
9 6 1 5 3 7 2 8 4
2 8 7 4 1 9 6 3 5
3 4 5 2 8 6 1 7 9
```
Contributions
Contributions to improve the solver or add new features are welcome! Please submit a pull request with your changes.
