# Generated by Django 2.2.7 on 2019-11-20 05:39

from django.db import migrations, models
import django.utils.timezone


class Migration(migrations.Migration):

    dependencies = [
        ('movies', '0001_initial'),
    ]

    operations = [
        migrations.AddField(
            model_name='movie',
            name='open_date',
            field=models.DateTimeField(default=django.utils.timezone.now),
        ),
    ]
