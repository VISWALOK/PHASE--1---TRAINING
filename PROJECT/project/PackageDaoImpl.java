import java.util.ArrayList;
import java.util.List;

public class PackageDaoImpl implements PackageDao {
    private List<Package> packageList = new ArrayList<>();

    public void addPackage(Package p) {
        packageList.add(p);
    }

    public Package findPackageById(String packageId) {
        for (Package p : packageList) {
            if (p.getPackageId().equals(packageId)) {
                return p;
            }
        }
        return null;
    }

    public List<Package> fetchAllPackages() {
        return packageList;
    }

    public void calculatePackageCost(Package p) {
        double basicTotal = p.getBasicFare() * p.getNoOfDays();
        double discount = 0;

        if (p.getNoOfDays() > 10) discount = 0.07;
        else if (p.getNoOfDays() > 8) discount = 0.05;
        else if (p.getNoOfDays() > 5) discount = 0.03;

        double discountAmount = basicTotal * discount;
        double costAfterDiscount = basicTotal - discountAmount;
        double gst = costAfterDiscount * 0.12;
        double totalCost = costAfterDiscount + gst;

        p.setPackageCost(totalCost);
    }
}