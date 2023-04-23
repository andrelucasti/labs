use std::fs::File;

#[derive(Debug)]
pub enum VideoState{
    Unavailable,
    Available,
}

#[derive(Debug)]
pub struct VideoFile {
    pub id: uuid::Uuid,
    pub state: VideoState,
    pub file: File
}

impl VideoFile {
    pub fn new(file: File) -> Self {
        Self {
            id: uuid::Uuid::new_v4(),
            state: VideoState::Unavailable,
            file
        }
    }
}