public class Package {
    private String packageId;
    private String source;
    private String destination;
    private int noOfDays;
    private double basicFare;
    private double packageCost;

    public Package(String packageId, String source, String destination, int noOfDays, double basicFare) {
        this.packageId = packageId;
        this.source = source;
        this.destination = destination;
        this.noOfDays = noOfDays;
        this.basicFare = basicFare;
    }

    public String getPackageId() { return packageId; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public int getNoOfDays() { return noOfDays; }
    public double getBasicFare() { return basicFare; }
    public double getPackageCost() { return packageCost; }

    public void setPackageCost(double packageCost) { this.packageCost = packageCost; }
}