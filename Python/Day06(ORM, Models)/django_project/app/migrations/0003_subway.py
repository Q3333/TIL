# Generated by Django 2.2.7 on 2019-11-14 06:46

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('app', '0002_board_updated_at'),
    ]

    operations = [
        migrations.CreateModel(
            name='Subway',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.TextField()),
                ('date', models.DateTimeField(auto_now_add=True)),
                ('menu', models.TextField()),
                ('size', models.TextField()),
                ('bread', models.TextField()),
                ('source', models.TextField()),
            ],
        ),
    ]
