use std::fs::File;
use std::io::Error;
use crate::business::s3client;
use crate::business::s3client::{S3Client, UploadClient};
use crate::business::video_file::VideoFile;

pub struct UploadToS3 {
    pub client: S3Client,
}

impl UploadToS3 {
    pub fn new(client: S3Client) -> Self {
        Self {
            client,
        }
    }
}


fn mock_upload_file<U>(file: File, client: U) -> Result<String, Error> where U: UploadClient,
{

    let result = client.upload(&file);
    Ok(String::from("s3://bucket-name/path/to/file"))


}

mod test {
    use std::fs::File;
    use crate::business::s3client;
    use crate::business::upload_to_s3::{mock_upload_file, UploadToS3};
    use crate::business::video_file::VideoFile;

    #[test]
    fn should_return_s3_path_when_uploaded_with_success() {
        // Arrange
        let file = File::create("test.mp4").unwrap();
        let video_file = VideoFile::new(file, String::from("test"));

        // Act
        let mut client = s3client::MockUploadClient::new();
        client.expect_upload().returning(|_| Ok(String::from("s3://bucket-name/path/to/file")));

        let result = mock_upload_file(video_file.file, client);

        // Assert
        assert_eq!(result.unwrap(), String::from("s3://bucket-name/path/to/file"));
    }

}