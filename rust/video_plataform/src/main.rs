pub mod business;

use std::fs::File;
use business::video::Video;
use business::video_file::VideoFile;

fn main() {
    let video_file = VideoFile::new(
        File::open("test.mp4").unwrap());

    println!("video_file: {:?}", video_file);

    let video1 = Video::new (
        String::from("Podcast Intro"),
        String::from("This is the intro to the podcast"),
        video_file.id,
        uuid::Uuid::new_v4());

    println!("video1: {:?}", video1);
}
