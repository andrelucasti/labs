use std::fs::File;
use std::io::Error;
use mockall::*;

#[automock]
pub trait UploadClient {
    fn upload(&self, file: &File) -> Result<String, Error>;
}

pub struct S3Client {}

impl UploadClient for S3Client {
    fn upload(&self, file: &File) -> Result<String, Error> {
        Ok(String::from("s3://bucket-name/path/to/file"))
    }
}