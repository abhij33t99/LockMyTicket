up:
	docker compose up

down:
	docker compose down

up_build: build_discovery build_theatre build_auth
	docker compose up

build_theatre:
	cd theatre-service && docker compose build

build_auth:
	cd auth-service && docker compose build

build_discovery:
	cd discovery-service &&	docker compose build
