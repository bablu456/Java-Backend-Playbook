// 🏗️ Product Class
class Computer {
    // Required parameters
    private String HDD;
    private String RAM;

    // Optional parameters
    private boolean isGraphicsCardEnabled;
    private boolean isBluetoothEnabled;

    // Constructor Private (Sirf Builder hi access karega)
    private Computer(ComputerBuilder builder) {
        this.HDD = builder.HDD;
        this.RAM = builder.RAM;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    // Sirf Getters (Immutability)
    public String getHDD() { return HDD; }
    public String getRAM() { return RAM; }
    public boolean hasGraphicsCard() { return isGraphicsCardEnabled; }
    public boolean hasBluetooth() { return isBluetoothEnabled; }

    @Override
    public String toString() {
        return "Computer [RAM=" + RAM + ", HDD=" + HDD + ", GPU=" + isGraphicsCardEnabled + "]";
    }

    // 👷 Static Inner Builder Class
    public static class ComputerBuilder {
        // Same fields
        private String HDD;
        private String RAM;
        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;

        // Constructor for Required Fields
        public ComputerBuilder(String hdd, String ram) {
            this.HDD = hdd;
            this.RAM = ram;
        }

        // Setter methods that return 'this' (Fluent Interface)
        public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this; // Chain banane ke liye
        }

        public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        // Final step: Object banao
        public Computer build() {
            return new Computer(this);
        }
    }
}

 class ComputerBuilderDemo {
    public static void main(String[] args) {
        // Client Code: Dekho kitna readable hai!
        Computer gamingPC = new Computer.ComputerBuilder("1TB", "32GB")
                .setGraphicsCardEnabled(true)
                .setBluetoothEnabled(true)
                .build();

        Computer officePC = new Computer.ComputerBuilder("500GB", "8GB")
                .build(); // No GPU needed

        System.out.println("Gaming PC: " + gamingPC);
        System.out.println("Office PC: " + officePC);
    }
}