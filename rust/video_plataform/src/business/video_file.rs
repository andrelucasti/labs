#[derive(Debug)]
pub enum VideoState{
    Unavailable,
    Available,
}

#[derive(Debug)]
pub struct VideoFile {
    pub id: uuid::Uuid,
    pub state: VideoState,
    pub file_name: String,
    pub file_path: String, //s3://bucket-name/path/to/file
}

impl VideoFile {
    pub fn new( file_name: String, file_path: String ) -> Self {
        Self {
            id: uuid::Uuid::new_v4(),
            state: VideoState::Unavailable,
            file_name,
            file_path,
        }
    }
}