import java.util.List;

public interface PackageService {
    void addPackage(Package p) throws InvalidPackageIdException;
    Package findPackageById(String packageId);
    List<Package> fetchAllPackages();
    void calculatePackageCost(String packageId) throws InvalidPackageIdException;
}