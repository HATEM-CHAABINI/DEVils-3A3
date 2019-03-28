<?php

namespace AppBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Location
 *
 * @ORM\Table(name="location", indexes={@ORM\Index(name="fk_locataire", columns={"username_locateur"}), @ORM\Index(name="fk_livre", columns={"id_livre"})})
 * @ORM\Entity
 */
class Location
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date_location", type="date", nullable=false)
     */
    private $dateLocation;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date_a_rendre", type="date", nullable=false)
     */
    private $dateARendre;

    /**
     * @var \Livre
     *
     * @ORM\ManyToOne(targetEntity="Livre")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_livre", referencedColumnName="id")
     * })
     */
    private $idLivre;

    /**
     * @var \FosUser
     *
     * @ORM\ManyToOne(targetEntity="FosUser")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="username_locateur", referencedColumnName="username_canonical")
     * })
     */
    private $usernameLocateur;



    /**
     * Get id
     *
     * @return integer
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set dateLocation
     *
     * @param \DateTime $dateLocation
     *
     * @return Location
     */
    public function setDateLocation($dateLocation)
    {
        $this->dateLocation = $dateLocation;

        return $this;
    }

    /**
     * Get dateLocation
     *
     * @return \DateTime
     */
    public function getDateLocation()
    {
        return $this->dateLocation;
    }

    /**
     * Set dateARendre
     *
     * @param \DateTime $dateARendre
     *
     * @return Location
     */
    public function setDateARendre($dateARendre)
    {
        $this->dateARendre = $dateARendre;

        return $this;
    }

    /**
     * Get dateARendre
     *
     * @return \DateTime
     */
    public function getDateARendre()
    {
        return $this->dateARendre;
    }

    /**
     * Set idLivre
     *
     * @param \AppBundle\Entity\Livre $idLivre
     *
     * @return Location
     */
    public function setIdLivre(\AppBundle\Entity\Livre $idLivre = null)
    {
        $this->idLivre = $idLivre;

        return $this;
    }

    /**
     * Get idLivre
     *
     * @return \AppBundle\Entity\Livre
     */
    public function getIdLivre()
    {
        return $this->idLivre;
    }

    /**
     * Set usernameLocateur
     *
     * @param \AppBundle\Entity\FosUser $usernameLocateur
     *
     * @return Location
     */
    public function setUsernameLocateur(\AppBundle\Entity\FosUser $usernameLocateur = null)
    {
        $this->usernameLocateur = $usernameLocateur;

        return $this;
    }

    /**
     * Get usernameLocateur
     *
     * @return \AppBundle\Entity\FosUser
     */
    public function getUsernameLocateur()
    {
        return $this->usernameLocateur;
    }
}
