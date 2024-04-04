import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class MaximumSumPath {
    public static int maxSumPath(int[] X, int[] Y) {
        int sumX = 0, sumY = 0;
        List<Integer> path = new ArrayList<>();


        for (int i = 0; i < X.length; i++) {
            sumX += X[i];
            path.add(X[i]);
        }


        boolean commonFound = false;
        for (int i = 0; i < Y.length; i++) {
            sumY += Y[i];
            if (!commonFound && path.contains(Y[i])) {
                int index = path.indexOf(Y[i]);
                path.subList(index, path.size()).clear();
                commonFound = true;
            }
            path.add(Y[i]);
        }


        if (sumX >= sumY) {
            System.out.print("Maximum Sum Path: ");
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i));
                if (i != path.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
            return sumX;
        } else {
            System.out.print("Maximum Sum Path: ");
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i));
                if (i != path.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
            return sumY;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the Array1 size");
        int size1 = Integer.parseInt(br.readLine());

        System.out.println("Enter the Array1 elements");
        int X[] = new int[size1];
        for (int i = 0; i < X.length; i++) {
            X[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("Enter the Array2 size");
        int size2 = Integer.parseInt(br.readLine());

        System.out.println("Enter the Array2 elements");
        int Y[] = new int[size2];
        for (int i = 0; i < Y.length; i++) {
            Y[i] = Integer.parseInt(br.readLine());
        }

        int maxSum = maxSumPath(X, Y);
        System.out.println("Maximum Sum: " + maxSum);
    }
}
