public class EnumTest {
    public enum Name {

        StrikeThroughPrice("false", 1),
        PromotionDynamicAds("false", 2),
        NavigationDynamicAds("false", 3),
        PublishToDB("false", 4),
        PublishToZoomShop("false", 5),
        PublishProductAttributesToZoomShop("false", 6),
        PublishToFirestore("false", 7)
        ;

        private String defaultValue;
        private int val;

        Name(String defaultValue, int val) {
            this.defaultValue = defaultValue;
            this.val = val;
        }

        public String getDefault() {
            return defaultValue;
        }

        public int getVal() {
            return val;
        }
    }

    public static void main(String[] args) {
        for (Name name : Name.values() ) {
            System.out.println(name.name() + name.getDefault());
        }
        System.out.println(Name.StrikeThroughPrice);
    }

}
