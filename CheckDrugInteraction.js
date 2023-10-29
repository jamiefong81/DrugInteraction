import { drugNameToRxcui } from './DrugNameToRxcui.js'
import getDrugInteraction from './GetDrugInteraction.js';


// Checks the list of all drug interactions from the getDrugInteraction function
// Checks if the old drugs' names are in the list. If they are, then there is a drug interaction
// Run this function in a loop where the oldDrugName is the variable that's being changed
// I.e., run this function for every old drug
// New drug is the new drug the patient is being treated with. You're checking if there is a conflict with
// any of the old drugs.
async function checkDrugInteraction(newDrugName, oldDrugName) {
    let rxcui = await drugNameToRxcui(newDrugName);

    let listOfInteractions = await getDrugInteraction(rxcui); // include await if necessary
    let listOfInteractionNames = listOfInteractions[0];
    let listOfInteractionDescriptions = listOfInteractions[1];
    if ((listOfInteractionNames).includes(oldDrugName.toLowerCase())) {
        console.log("Drug Interaction found!")
        let indexOfName = listOfInteractionNames.indexOf(oldDrugName);
        let descriptionOfInteraction = listOfInteractionDescriptions[indexOfName];
        return descriptionOfInteraction;
        // console.log(descriptionOfInteraction);
    } else {
        // console.log("No drug interaction found.");
        return null; // Returns null if no interaction is found, otherwise, it will return the description of interaction
    };

};

// Here to show how it works
// const App = async () => {
//     await checkDrugInteraction("Acetaminophen", "saxagliptin anhydrous");
// };

// App();