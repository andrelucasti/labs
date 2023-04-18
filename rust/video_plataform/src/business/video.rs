#[derive(Debug)]
pub struct Video {
    pub id: uuid::Uuid,
    pub title: String,
    pub description: String,
    pub video_id: uuid::Uuid,
    pub thumbnail_id: uuid::Uuid,
}

impl Video {
    pub fn new( title: String, description: String, video_id: uuid::Uuid, thumbnail_id: uuid::Uuid ) -> Self {
        Self {
            id: uuid::Uuid::new_v4(),
            title,
            description,
            video_id,
            thumbnail_id,
        }
    }
}

