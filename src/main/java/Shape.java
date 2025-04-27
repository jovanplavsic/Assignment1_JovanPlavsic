public class Shape extends Matrix {
    private String name;

    public Shape(String name, int[][] data) {
        super(data);

        if (data == null || data.length < 1 || data[0].length < 1) {
            throw new IllegalArgumentException("Matrix cannot be null or empty");
        }

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] != 0 && data[i][j] != 1) {
                    throw new IllegalArgumentException("Matrix must only contain 0 and 1");
                }
            }
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        int[][] beehive = {
                {0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0},
                {0, 1, 0, 0, 1, 0},
                {0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0}
        };

        int[][] boat = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0}
        };

        Shape beehiveShape = new Shape("Beehive", beehive);
        Shape boatShape = new Shape("Boat", boat);

        BoolMatrixPrinter printer = new BoolMatrixPrinter();

        System.out.println("Beehive:");
        System.out.println(printer.print(beehiveShape));
        System.out.println();

        System.out.println("Boat:");
        System.out.println(printer.print(boatShape));
    }

}
