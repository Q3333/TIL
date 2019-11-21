from django.db import models
from imagekit.models import ProcessedImageField, ImageSpecField
from imagekit.processors import ResizeToFill, Thumbnail

# Create your models here.

def board_img_path(instance, filename):
    return f"boards/{instance.pk}번글/{filename}"

class Board(models.Model):
    title = models.CharField(max_length=20)
    content = models.TextField()
    updated = models.DateTimeField(auto_now=True)
    created = models.DateTimeField(auto_now_add=True)

    # # #ResizeToFill ver.1 (원본 없음)
    # image = ProcessedImageField(
    #     upload_to = "boards/images_rtf",
    #     processors = [ResizeToFill(600,500)],
    #     format = "JPEG",
    #     options = {
    #         'quality' : 90
    #     }
    # )

    # # Thumbnail Ver.1 (원본 없음)
    # image = ProcessedImageField(
    #     upload_to = "boards/images_tnl",
    #     processors = [Thumbnail(600,500)],
    #     format = "JPEG",
    #     options = {
    #         'quality' : 90
    #     }
    # )
   

    # Thumbnail 원본 저장하고 썸네일은 캐쉬 형태로 Ver2
    image = models.ImageField(blank=True, upload_to=board_img_path)
    image_thumb = ImageSpecField(
        source="image",
        processors = [Thumbnail(250,350)],
        format = "JPEG",
        options = { 
            'quality' : 90
        }
    )
    
    def __str__(self):
        return self.title
