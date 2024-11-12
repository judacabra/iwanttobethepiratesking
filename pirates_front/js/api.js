class ApiService {
    constructor() {
        this.urlSpringBoot = 'http://localhost:8081';
        this.urlAPIOnePiece = 'https://api.api-onepiece.com/v2';
    }

    async fetch(url, endpoint) {
        try {
            const response = await fetch(`${url}/${endpoint}`);

            if (!response.ok) {
                throw new Error('Error en la solicitud');
            }

            return await response.json();
        } catch (error) {
            console.error('Hubo un problema con la solicitud:', error);

            throw error;
        }
    }

    async fetchPOST(url, endpoint, formData) {
        try {
            const response = await fetch(`${url}/${endpoint}`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(formData),
            });

            if (!response.ok) {
                throw new Error('Error en la solicitud');
            }

            return await response.json();
        } catch (error) {
            console.error('Hubo un problema con la solicitud:', error);

            throw error;
        }
    }

    async fetchPUT(url, endpoint, formData) {
        try {
            const response = await fetch(`${url}/${endpoint}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(formData),
            });

            if (!response.ok) {
                throw new Error('Error en la solicitud');
            }

            return await response.json();
        } catch (error) {
            console.error('Hubo un problema con la solicitud:', error);

            throw error;
        }
    }

    async fetchDELETE(url, endpoint) {
        let alert;

        try {
            const response = await fetch(`${url}/${endpoint}`, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json',
                },
            });
    
            if (!response.ok) {
                const errorData = await response.json();
                throw new Error(errorData.metaData.message); 
            }
    
            const data = await response.json();
            alert = 'Tripulación eliminada existosamente.';   
        } catch (error) {
            alert = 'No se puede eliminar la tripulación cuando tiene tripulantes.'; 
        }

        return alert;
    }
    

    // Spring boot (BD)
    getCharactersFromBD() {
        return this.fetch(this.urlSpringBoot ,'characters');
    }

    getCharactersByCrew(id) {
        return this.fetch(this.urlSpringBoot ,`character_crew/${id}`);
    }

    getCrews() {
        return this.fetch(this.urlSpringBoot, 'crews');
    }

    getCrewById(id) {
        return this.fetch(this.urlSpringBoot, `crews/${id}`);
    }

    getUsers() {
        return this.fetch(this.urlSpringBoot, 'users');
    }

    getUserById(id) {
        return this.fetch(this.urlSpringBoot, `users/${id}`);
    }

    insertCrew(crewData){
        return this.fetchPOST(this.urlSpringBoot, `crews/`, crewData);
    }

    updateCrew(crewData){
        return this.fetchPUT(this.urlSpringBoot, `crews/`, crewData);
    }

    deleteCrew(id){
        return this.fetchDELETE(this.urlSpringBoot, `crews/${id}`);
    }

    insertCharacter(characterData){
        return this.fetchPOST(this.urlSpringBoot, `characters/`, characterData);
    }

    // API One Piece
    getCharactersFromAPI() {
        return this.fetch(this.urlAPIOnePiece ,'characters/en');
    }

    getCharacterByIdFromAPI(id) {
        return this.fetch(this.urlAPIOnePiece ,`characters/en/${id}`);
    }
}
