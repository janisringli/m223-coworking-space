-- Insert places
INSERT INTO public."Place" (id, "placeNumber") VALUES (1, 6);
INSERT INTO public."Place" (id, "placeNumber") VALUES (2, 5);

-- Insert roles
INSERT INTO public."Roles" (id, "roleName") VALUES (1, 'Mitglied');
INSERT INTO public."Roles" (id, "roleName") VALUES (2, 'Admin');

-- Insert users
INSERT INTO public."User" (id, username, "firstName", "lastName", password, email, roles) VALUES (1, 'user', 'user', 'user', 'user', 'a@a.ch', 1);
INSERT INTO public."User" (id, username, "firstName", "lastName", password, email, roles) VALUES (2, 'admin', 'admin', 'admin', 'admin' ,'b@b.ch', 2);
INSERT INTO public."User" (id, username, "firstName", "lastName", password, email, roles) VALUES (3, 'mitglied', 'mitglied', 'mitglied', 'mitglied', 'c@bc.ch' ,1);


-- Insert bookings
INSERT INTO public."Booking" (id, "date", "endTime", "startTime", place, "user") VALUES (1,  '2023-11-04', '2023-11-03T12:45:30', '2032-11-03T12:45:30', 1, 2);
INSERT INTO public."Booking" (id, "date", "endTime", "startTime", place, "user") VALUES (2, '2023-11-04', '2022-03-10 12:15:50', '2022-03-10 12:15:50', 1, 1);

-- Insert kaffeeLog
INSERT INTO public."Coffee" (id, "time", "price") VALUES (1, '2018-11-03T12:45:30', 2.3);
INSERT INTO public."Coffee" (id, "time", "price") VALUES (2, '2018-11-03T12:45:30', 4.3);