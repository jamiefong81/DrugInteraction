import express, { json } from 'express';
import Axios from 'axios';
import { format } from 'morgan';

const app = express();

// Sends get request with certain rxcui to get all drug interactions
// Puts all the names of the interactions and their descriptions in a list
// Returns this list to be compared with
const getDrugInteraction = async(rxcui) => {
    let uri = "https://rxnav.nlm.nih.gov";
    let directory = "/REST/interaction/interaction.json?rxcui=" + rxcui;
    let fullUri = uri +directory;

    const drugInteractions = await Axios.get(fullUri);
    const jsonData = drugInteractions.data;
    let namesOfInteractions = [];
    let descriptionOfInteractions = [];
    let index = 0;
    
    // This loop puts all the names of all the drug interactions into their respective arrays
    while (true) {
        try {
            const interactionTypeGroup= jsonData.interactionTypeGroup;
            const interactionType = interactionTypeGroup[0].interactionType;
            const interactionPair = interactionType[0].interactionPair;
            const interactionConcept = interactionPair[index].interactionConcept; // Change to get next drug
            const minConceptItem = interactionConcept[1].minConceptItem;

            namesOfInteractions.push(minConceptItem.name.toLowerCase());
            descriptionOfInteractions.push(interactionPair[index].description);
            // console.log(namesOfInteractions);
            index += 1;
        } catch (error) {
            break;
        }

    };

    // Returns an array of arrays. The first one is the list of all drug interactions, second is the description array
    let finalReturnList = [namesOfInteractions, descriptionOfInteractions];
    return finalReturnList;
    
};

export default getDrugInteraction;
