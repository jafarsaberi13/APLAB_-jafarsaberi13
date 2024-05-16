
# Matrix Rotation

This Java code provides a solution for rotating a square matrix of integers by 90 degrees clockwise in-place.

## Usage

To use this code, you can follow these steps:

1. Include the `Solution` class in your Java project.
2. Create an instance of the `Solution` class.
3. Call the `rotate` method, passing the square matrix as an argument.

Example:
```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};
Solution solution = new Solution();
solution.rotate(matrix);
```

After calling the `rotate` method, the `matrix` will be rotated by 90 degrees clockwise.

## Methodology

The rotation is achieved through a two-step process:
1. Iterative Layer-by-Layer Rotation:
   - The matrix is divided into layers, starting from the outermost layer and moving inwards.
   - Each layer is rotated clockwise by swapping elements in a circular manner.
2. Element Swap:
   - Within each layer, elements are swapped in a cyclic manner.

## Method Details

### `rotate(int[][] matrix)`

This method initiates the rotation process by iterating through the layers of the matrix and invoking the `rotate` method for each layer.

### `rotate(int[][] matrix, int i, int j, int count)`

This method performs the actual rotation of a layer within the matrix. It takes the matrix, starting and ending indices of the layer (`i` and `j` respectively), and the current count within the layer as arguments. The elements within the layer are swapped in a cyclic manner to achieve the rotation.

## Note

- This code modifies the input matrix in-place. Ensure that you have a copy of the original matrix if preservation is needed.
- The matrix must be square (i.e., the number of rows must be equal to the number of columns) for the rotation to work correctly.

```

Feel free to adjust or expand upon this README according to your project's requirements or preferences.
