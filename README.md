#Sudoku Solver in Java

📌 #Introduction

This project implements a Sudoku Solver in Java using the Backtracking Algorithm. Given a partially filled 9x9 Sudoku board, the program attempts to fill in the missing numbers while ensuring that:

Each row contains unique numbers from 1 to 9.

Each column contains unique numbers from 1 to 9.

Each 3x3 sub-grid contains unique numbers from 1 to 9.

If a solution exists, the program prints the solved Sudoku board; otherwise, it notifies that no solution is possible.

🛠 #Features

✔ Solves any valid 9x9 Sudoku puzzle efficiently using recursion and backtracking.
✔ Ensures all Sudoku rules are followed.
✔ Outputs a neatly formatted solved Sudoku board.
✔ Simple and easy-to-understand Java implementation.

📜 #Algorithm Explanation

Find an Empty Cell: Locate the first unassigned position in the grid.

Try a Number: Place numbers (1-9) one by one and check if it's a valid placement.

Backtrack if Needed: If placing a number leads to a dead end, reset it and try the next possibility.

Repeat Until Solved: The algorithm continues recursively until the Sudoku board is completely filled or no solution is found.

🚀 #Getting Started

#Prerequisites

Java installed (JDK 8 or higher).

A Java IDE (Eclipse, IntelliJ, VS Code) or a terminal with javac.
