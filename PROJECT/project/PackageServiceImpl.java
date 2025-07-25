public class PackageServiceImpl implements PackageService {
    private PackageDao dao = new PackageDaoImpl();

    private void validatePackageId(String packageId) throws InvalidPackageIdException {
        if (packageId == null || packageId.length() != 7) {
            throw new InvalidPackageIdException("Invalid Package Id");
        }
    }

    public void addPackage(Package p) throws InvalidPackageIdException {
        validatePackageId(p.getPackageId());
        dao.addPackage(p);
    }

    public Package findPackageById(String packageId) {
        return dao.findPackageById(packageId);
    }

    public java.util.List<Package> fetchAllPackages() {
        return dao.fetchAllPackages();
    }

    public void calculatePackageCost(String packageId) throws InvalidPackageIdException {
        validatePackageId(packageId);
        Package p = dao.findPackageById(packageId);
        if (p != null) {
            dao.calculatePackageCost(p);
        } else {
            throw new InvalidPackageIdException("Invalid Package Id");
        }
    }
}