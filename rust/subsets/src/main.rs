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
    println!("Hello, world!");

    let region = Subset::new(SubsetKind::REGION, String::from("Lisbon"));
    println!("{:?}", region);

    let subregion = Subset::new(SubsetKind::SUBREGION, String::from("Benfica"));
    println!("{:?}", subregion);
}
