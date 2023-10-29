import Axios from 'axios';

// This converts the drug name to an ID the API uses to check for drug interactions
export async function drugNameToRxcui(drugName) {
    let uri = "https://rxnav.nlm.nih.gov/REST/rxcui.json?name=" + drugName;
    const rxcui = (await Axios.get(uri)).data.idGroup.rxnormId[0];
    return rxcui;
};