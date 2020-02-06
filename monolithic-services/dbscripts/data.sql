INSERT INTO truyum.menu_item(me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery,me_image_url) VALUES 
('Vivek',99.00,true,'2017/03/15','MainCourse',true,'https://images.unsplash.com/photo-1528735602780-2552fd46c7af?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60'),
('Burger',129.00,true,'2017/12/23','MainCourse',false,'https://images.unsplash.com/photo-1547584370-2cc98b8b8dc8?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60'),
('Pizza',149.00,true,'2018/08/21','MainCourse',false,'https://images.unsplash.com/photo-1513104890138-7c749659a591?ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60'),
('French Fries',57.00,false,'2017/07/02','Startes',true,'https://images.unsplash.com/photo-1480076732613-644bee94d3c9?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1052&q=80'),
('Chocolate Brownie',32.00,true,'2022/11/02','Dessert',true,'https://images.unsplash.com/photo-1528735602780-2552fd46c7af?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60'); 


INSERT INTO truyum.user(us_username,us_password) VALUES ('vivek','$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK'),
('user','$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK'),('admin','$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK');

INSERT INTO truyum.role(ro_name) VALUES ('USER'),('ADMIN');

INSERT INTO truyum.user_role(ur_us_id,ur_ro_id) values (1,1),(2,2),(3,1);

