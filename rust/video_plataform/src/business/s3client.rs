use std::fs::File;
use std::io::Error;
use mockall::*;
use crate::business::video_file::VideoFile;

#[automock]
pub trait UploadClient {
    fn upload(&self, file: &VideoFile) -> Result<String, Error>;
}

pub struct S3Client {}

impl UploadClient for S3Client {
    fn upload(&self, video_file: &VideoFile) -> Result<String, Error> {
        Ok(String::from("s3://bucket-name/path/to/file"))
    }
}