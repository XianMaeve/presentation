package elementsoffashion.demo;
import elementsoffashion.demo.models.*;
import elementsoffashion.demo.repositorites.*;
import elementsoffashion.demo.usermanagement.User;
import elementsoffashion.demo.usermanagement.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.Arrays;

@Component
public class Populator implements CommandLineRunner {

    @Resource
    private BottomsRepository bottomRepo;
    @Resource
    private JacketsRepository jacketRepo;
    @Resource
    private ShoesRepository shoeRepo;
    @Resource
    private TopsRepository topRepo;
    @Resource
    private UserRepository userRepo;

    @Override
    public void run(String... args) throws Exception {

    Bottoms blueJeans = new Bottoms("Long Pants", "Blue", "26x38",
            "images/blueJeans.jpg", "Thunderstorm", "Drizzle", "Rain",
            "Snow", "Dust", "Clear", "Clouds");

    Bottoms khakiPants = new Bottoms("Khaki Pants", "Tan", "30x38",
            "/images/khaki.jpg", "Clear", "Dust", "Clouds");

    Bottoms blackShorts = new Bottoms("Gym Shorts", "Black", "Large",
            "images/gymShorts.jpg", "Clear", "Clouds", "Dust");

    Bottoms sweatPants = new Bottoms ("Sweat Pants", "Grey", "XL",
            "images/sweat.jpg", "Snow", "Thunderstorm");

    bottomRepo.save(blueJeans);
    bottomRepo.save(khakiPants);
    bottomRepo.save(blackShorts);
    bottomRepo.save(sweatPants);

    Jackets columbia = new Jackets("Columbia Tipton Peak", "Blue & Navy", "XL",
            "/images/columbia.jpg","Snow", "Thunderstorm", "Drizzle", "Dust");

    Jackets dockers = new Jackets("Dockers Walking Coat", "Black","XXL",
            "/images/dockers.jpg","Drizzle", "Clear", "Clouds");

    Jackets supreme = new Jackets("Supreme Pull-Over", "Grey & Red", "XL",
            "/images/supreme.jpg","Drizzle", "Clear", "Clouds");

    Jackets wrangler = new Jackets("Wrangler Long Sleeve Heavy Shirt", "Plaid Red & Black", "L",
            "/images/wrangler.jpg","Clear", "Clouds");

    jacketRepo.save(columbia);
    jacketRepo.save(dockers);
    jacketRepo.save(supreme);
    jacketRepo.save(wrangler);

    Shoes converse = new Shoes("Converse","High-Top","White w/ Red Stripe","10.5",
            "/images/highTops.jpg", "Clear");

    Shoes nike7 = new Shoes("Nike", "Kyrie 7", "Black", "10.5",
            "/images/kyrie7.jpg", "Drizzle", "Clear", "Clouds");

    Shoes yeezy = new Shoes("Yeezy", "Yeezy Boost 350 v2", "Blue Tint", "11",
            "/images/yeezy.jpg","Clear", "Clouds");

    Shoes adidas = new Shoes("Adidas", "Ultraboost", "Core Black", "10",
            "/images/ultraboost.jpg","Snow", "Clear", "Drizzle", "Clouds");

    Shoes timbs = new Shoes("Timberland", "SnowHaze", "Brown", "10.5",
            "/images/snowH.jpg", "Snow", "Thunderstorm", "Drizzle");

    Shoes sketchers = new Shoes("Sketchers", "Equalizer Double Play", "Black", "10.5",
            "/images/sketchers.jpg", "Thunderstorm", "Drizzle", "Rain",
            "Snow", "Dust", "Clear", "Clouds");

    shoeRepo.save(converse);
    shoeRepo.save(nike7);
    shoeRepo.save(yeezy);
    shoeRepo.save(adidas);
    shoeRepo.save(timbs);
    shoeRepo.save(sketchers);

    Tops whiteTee = new Tops("White Crew-Neck", "White", "L", "/images/whiteTee.jpg",
            "Clear", "Clouds");

    Tops newGeneration = new Tops("New Generation Striped Tee", "Red & Black Striped", "L",
            "/images/newGen.jpg","Dust", "Clear", "Clouds" , "Rain");

    Tops graphicTee = new Tops("Polaroid Tee", "Black", "S",
            "/images/graphicTee.jpg", "Thunderstorm", "Drizzle", "Rain", "Snow", "Dust", "Clear", "Clouds");

    Tops vanHeusen = new Tops("Van Heusen Long Sleeve", "Checkered Blue & White", "XL",
            "/images/vanH.jpg", "Snow", "Dust", "Clear", "Clouds", "Rain");

    topRepo.save(whiteTee);
    topRepo.save(newGeneration);
    topRepo.save(graphicTee);
    topRepo.save(vanHeusen);

    User testUser = new User("user", "password", "USER");

    User testAdmin = new User("admin", "password", "ADMIN");

    userRepo.save(testAdmin);
    userRepo.save(testUser);

    //create admin users
//    Closet evanCloset = new Closet();
//    Closet cassandraCloset = new Closet();
//    Closet maeveCloset = new Closet();
//    Closet rhondaCloset = new Closet();
//    Closet armandCloset = new Closet();
//    Closet ramonCloset = new Closet();
//    Closet barryCloset = new Closet();
//    closetRepo.saveAll(Arrays.asList(evanCloset, cassandraCloset, maeveCloset, rhondaCloset, armandCloset, ramonCloset, barryCloset));

//    User adkinsevan = new User("adkinsevan", "evanpassword", "ADMIN", evanCloset);
//    User camos2020 = new User("camos2020", "cassandrapassword", "ADMIN", cassandraCloset);
//    User xianmaeve = new User("XianMaeve", "maevepassword", "ADMIN", maeveCloset);
//    User rsmile74 = new User("rsmile74", "rhondapassword", "ADMIN", rhondaCloset);
//    User armani87 = new User("armani87", "armandpassword", "ADMIN", armandCloset);
//    User ramonfields = new User("ramon-fields", "ramonpassword", "ADMIN", ramonCloset);
//    User broberston93 = new User("brobertson93", "barrypassword", "ADMIN", barryCloset);
//    userRepo.saveAll(Arrays.asList(adkinsevan, camos2020, xianmaeve, rsmile74, armani87, ramonfields,broberston93));


}
}