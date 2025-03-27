# Sudoku Solver in Java

## 📌 Introduction
This project implements a **Sudoku Solver** in Java using the **Backtracking Algorithm**. Given a partially filled 9x9 Sudoku board, the program attempts to fill in the missing numbers while ensuring that:
- Each row contains unique numbers from 1 to 9.
- Each column contains unique numbers from 1 to 9.
- Each 3x3 sub-grid contains unique numbers from 1 to 9.

If a solution exists, the program prints the solved Sudoku board; otherwise, it notifies that no solution is possible.

## 🛠 Features
✔ Solves any valid 9x9 Sudoku puzzle efficiently using recursion and backtracking.  
✔ Ensures all Sudoku rules are followed.  
✔ Outputs a neatly formatted solved Sudoku board.  
✔ Simple and easy-to-understand Java implementation.  

## 📜 Algorithm Explanation
1. **Find an Empty Cell**: Locate the first unassigned position in the grid.
2. **Try a Number**: Place numbers (1-9) one by one and check if it's a valid placement.
3. **Backtrack if Needed**: If placing a number leads to a dead end, reset it and try the next possibility.
4. **Repeat Until Solved**: The algorithm continues recursively until the Sudoku board is completely filled or no solution is found.

## 🚀 Getting Started
### Prerequisites
- Java installed (JDK 8 or higher).
- A Java IDE (Eclipse, IntelliJ, VS Code) or a terminal with `javac`.

### Running the Program
1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/sudoku-solver-java.git
   ```
2. Navigate to the project directory:
   ```sh
   cd sudoku-solver-java
   ```
3. Compile and run the program:
   ```sh
   javac Sudoku.java
   java Sudoku
   ```

## 📌 Example Input & Output
### Input Sudoku Board
```
3 0 6 5 0 8 4 0 0
5 2 0 0 0 0 0 0 0
0 8 7 0 0 0 0 3 1
0 0 3 0 1 0 0 8 0
9 0 0 8 6 3 0 0 5
0 5 0 0 9 0 6 0 0
1 3 0 0 0 0 2 5 0
0 0 0 0 0 0 0 7 4
0 0 5 2 0 6 3 0 0
```

### Solved Output
```
3 1 6 5 7 8 4 9 2
5 2 9 1 3 4 7 6 8
4 8 7 6 2 9 5 3 1
2 6 3 4 1 5 9 8 7
9 7 4 8 6 3 1 2 5
8 5 1 7 9 2 6 4 3
1 3 8 9 4 7 2 5 6
6 9 2 3 5 1 8 7 4
7 4 5 2 8 6 3 1 9
```

## 🔧 Future Enhancements
- Support for different Sudoku board sizes (4x4, 16x16, etc.).
- Implement a graphical interface for solving Sudoku interactively.
- Optimization of the backtracking approach for better performance.

## 🤝 Contribution
Contributions are welcome! Feel free to fork this repository and submit a pull request with improvements.

