#[derive(Debug)]
enum SubsetKind {
    REGION,
    SUBREGION,
    ZONE,
}

use uuid::Uuid;
#[derive(Debug)]
struct Subset {
    id: Uuid,
    kind: SubsetKind,
    name: String,


}

//Constructor Using the Field Init Shorthand
impl Subset {
    fn new(kind: SubsetKind, name: String) -> Self {
        let id = Uuid::new_v4();
        Subset {
            id,
            kind,
            name,
        }
    }
}

fn main() {
    let region = Subset::new(SubsetKind::REGION, String::from("Lisbon"));
    println!("{:?}", region);

    let subregion = Subset::new(SubsetKind::SUBREGION, String::from("Benfica"));
    println!("{:?}", subregion);

    let my_literal_string = "Hello, world in literal string";
    println!("{}", my_literal_string);

    let mut my_string = String::from("Hello, world!");
    // push_str() appends a literal to a String
    my_string.push_str(" I'm a string!");



    let s1 = String::from("hello");
    let s1_ptr = &s1 as *const String;
    println!("{}", format!("s1_value: {} s3_ptr: {:p}", s1, s1_ptr));


    let s2 = &s1;
    let s2_ptr = s2;
    println!("{}", format!("s2_value: {} s3_ptr: {:p}", s2, s2_ptr));
}
