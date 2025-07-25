import java.util.List;

public interface PackageDao {
    void addPackage(Package p);
    Package findPackageById(String packageId);
    List<Package> fetchAllPackages();
    void calculatePackageCost(Package p);
}