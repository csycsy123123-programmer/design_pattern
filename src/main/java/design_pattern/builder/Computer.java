package design_pattern.builder;

public class Computer {
    private final String cpu;
    private final String gpu;
    private final String ram;
    private final String disk;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.gpu = builder.gpu;
        this.ram = builder.ram;
        this.disk = builder.disk;
    }

    public static class Builder {
        private String cpu;
        private String gpu;
        private String ram;
        private String disk;

        public Builder() {

        }

        public Builder withCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder withGpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Builder withRam(String ram) {
            this.ram = ram;
            return this;
        }

        public Builder withDisk(String disk) {
            this.disk = disk;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
