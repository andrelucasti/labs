struct Purchase {
    id: i32,
    name: String,
    price: f64,
    quantity: i32,
}

#[derive(Debug)]
struct Product(i32, String, f64);
#[derive(Debug)]
struct PurchaseV2(i32, Product, i32);

fn show_me(p: &Purchase) {
    println!("{0}, {1}, {2}, {3}", p.id, p.name, p.price, p.quantity);
}
fn show_me_v2(p_v2: &PurchaseV2) {
    println!("{:?}", p_v2);
}

//Using the Field Init Shorthand when Variables and Fields Have the Same Name
fn new_purchase(name: String, price: f64, quantity: i32) -> Purchase {
    Purchase {
        id: 2,
        name,
        price,
        quantity
    }
}


fn main() {
    println!("Hello, world!");

    let p = Purchase {
        id: 1,
        name: String::from("Whey Protein"),
        price: 24.99,
        quantity: 1,
    };

    println!("my purchase - p1:");
    show_me(&p);

    let p2 = new_purchase(String::from("Creatine - Lemon Flavor"), 31.99, 1);
    println!("my shorthand purchase - p2:");
    show_me(&p2);


    //Creating Instances from Other Instances with Struct Update Syntax
    let same_purchase_but_in_another_instance = Purchase {
        id: p.id,
        name: p.name,
        price: p.price,
        quantity: p.quantity,
    };

    let p3 = same_purchase_but_in_another_instance;
    println!("my same purchase - p3:");
    show_me(&p3);

    //The syntax .. specifies that the remaining fields not explicitly set should have the same value as the fields in the given instance.
    let p4 = Purchase {
        id: 4,
        name: String::from("Creatine - Strawberry Flavor"),
        ..p2
    };
    println!("my purchase with the syntax .. - p3:");
    show_me(&p4);


    //Using Tuple Structs Without Named Fields to Create Different Types
    let whey_protein = Product(1, String::from("Whey Protein"), 24.99);
    let p5 = PurchaseV2(1, whey_protein, 2);
    println!("my purchase without Named Fields - p5:");
    show_me_v2(&p5)
}