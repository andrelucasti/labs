use std::io;
use std::cmp::Ordering;
use rand::Rng;
fn main() {
    println!("Guess the number!");
    println!("Pls input your guess");

    let mut guess = String::new();
    let secret_number = rand::thread_rng().gen_range(1..=100);

    //println!("the secret number is: {secret_number}");

    io::stdin()
        .read_line(&mut guess)
        .expect("Failed to read line");

    println!("You guessed: {guess}");


    //Rust allows us to shadow the previous value of guess with a new one.
    let guess: u32 = guess.trim().parse().expect("Please type a number!");
    match guess.cmp(&secret_number){
        Ordering::Less => println!("Too small"),
        Ordering::Greater => println!("Too big"),
        Ordering::Equal => println!("You win !")
    }

    println!("the secret number is: {secret_number}");
}
